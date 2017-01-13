package playground.Util;

import com.opencsv.CSVReader;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.real2space.neumann.congraph.core.backpropagate.differentiation.Add;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Project Neumann
 * created 2017/01/11
 *
 * @author RealTwo-Space
 * @version 0
 */
public class DataFrame {
    private ArrayList<String> headers;
    private ArrayList<Column> columns;

    private DataFrame() {
        this.headers = new ArrayList<String>();
        this.columns = new ArrayList<Column>();
    }

    public static DataFrame readCSV(String filePath) {
        return readCSV(filePath, true);
    }

    public static DataFrame readCSV(String filePath, boolean isHeader) {
        try {
            CSVReader reader = new CSVReader(new FileReader(new File(filePath)));

            DataFrame res = new DataFrame();
            String[] nextLine;
            if (isHeader) {
                nextLine = reader.readNext(); //nextLineの初期化処理
                for (String line : nextLine) {
                    res.headers.add(line);
                }
            }

            Column col;
            while ((nextLine = reader.readNext()) != null) {
                col = new Column();
                for (String line : nextLine) {
                    col.add(line);
                }
                res.columns.add(col);
            }
            reader.close();
            return res;
        } catch (IOException e) {
            System.out.println("cannot read");
            return null;
        }
    }

    public DataFrame combine(DataFrame df) {
        DataFrame res = new DataFrame();

        int M = df.size();

        res.headers.addAll(this.headers);
        res.headers.addAll(df.headers);
        Column col;
        for (int i = 0; i < M; i++) {
            col = new Column();
            col.addAll(this.columns.get(i));
            col.addAll(df.columns.get(i));
            res.columns.add(col);
        }
        return res;
    }

    // indexes is header index
    public DataFrame remove(String... indexes) {
        ArrayList<String> heads = new ArrayList<String>();
        heads.addAll(headers);
        int N = indexes.length;
        int index;
        for (int i = 0; i < N; i++) {
            index = heads.indexOf(indexes[i]);
            heads.remove(index);
        }
        return this.getRows((String[]) heads.toArray());
    }

    // get row with header index
    public DataFrame getRow(String index) {
        int ind = this.headers.indexOf(index);
        return getRow(ind);
    }

    public DataFrame getRow(int index) {
        DataFrame res = new DataFrame();
        res.headers.add(this.headers.get(index));
        Column col;
        for (int i = 0, N = this.columns.size(); i < N; i++) {
            col = new Column();
            col.add(this.columns.get(i).get(index));
            res.columns.add(col);
        }
        return res;
    }

    public DataFrame getRows(String... indexes) {
        DataFrame res = new DataFrame();
        Column col;

        int N = indexes.length;
        int index[] = new int[N];
        for (int i = 0; i < N; i++) {
            index[i] = this.headers.indexOf(indexes[i]);
            res.headers.add(this.headers.get(index[i]));
        }

        for (int i = 0, M = this.columns.size(); i < M; i++) {
            col = new Column();
            for (int j = 0; j < N; j++) {
                col.add(this.columns.get(i).get(index[j]));
            }
            res.columns.add(col);
        }
        return res;
    }

    public DataFrame getColumn(int index) {
        return null;
    }

    public DataFrame getColumns(int top, int bottom) {
        DataFrame res = new DataFrame();
        res.headers = this.headers;
        Column col;

        if (bottom == -1) {
            bottom = this.size();
        }

        for (int i = top; i < bottom; i++) {
            col = this.columns.get(i);
            res.columns.add(col);
        }
        return res;
    }

    // convert string to dammies
    public DataFrame getDammies(String... indexes) {
        DataFrame rows = this.getRows(indexes);
        String[][] stringData = rows.toStringArray();

        ArrayList<String> dammyList = new ArrayList<String>();
        DataFrame res = new DataFrame();
        int N = stringData[0].length;
        int M = stringData.length;
        ArrayList<Integer> dammyNum = new ArrayList<Integer>();
        int num = 0;
        for (int i = 0; i < N; i++) {
            num = 0;
            dammyList.clear();
            for (int j = 0; j < M; j++) {
                if (dammyList.indexOf(stringData[j][i]) < 0) {
                    dammyList.add(stringData[j][i]);
                    res.headers.add(indexes[i] + "." + stringData[j][i]);
                    num++;
                }
            }
            dammyNum.add(num);
        }

        int dammyIndex;
        Column col;
        int D;
        for (int i = 0; i < M; i++) {
            col = new Column();
            for (int j = 0; j < N; j++) {
                dammyIndex = res.indexOf(indexes[j] + "." + stringData[i][j]);
                D = dammyNum.get(j);
                for (int k = 0; k < D; k++) {
                    if (k == dammyIndex) {
                        col.add(new DoubleType(1.0));
                    } else {
                        col.add(new DoubleType(0.0));
                    }
                }
            }
            res.columns.add(col);
        }
        return res;
    }

    public String[][] toStringArray() {
        int N = this.columns.size();
        String[][] res = new String[N][];
        for (int i = 0; i < N; i++) {
            res[i] = this.columns.get(i).getStringArray();
        }
        return res;
    }

    public double[][] toDoubleArray() {
        int N = this.columns.size();
        double[][] res = new double[N][];
        for (int i = 0; i < N; i++) {
            res[i] = this.columns.get(i).getDoubleArray();
        }
        return res;
    }

    public int indexOf(String index) {
        return this.headers.indexOf(index);
    }

    public int size() {
        return this.columns.size();
    }

    public void head() {
        int N = size();
        if (N > 10) {
            N = 10;
        }

        String res = "  | ";
        for (int i = 0, M = this.headers.size(); i < M; i++) {
            res += this.headers.get(i) + " | ";
        }
        for (int i = 0; i < N; i++) {
            res += "\n";
            res += i + " ";
            res += this.columns.get(i);
        }

        System.out.println(res);
    }
}
