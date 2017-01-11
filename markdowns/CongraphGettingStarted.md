# Congraph Tutorial

## Get started

### Calculation

```java
Input:

Congraph cg = new Congraph();

CNode a = cg.constant(2.0);
CNode b = cg.constant(3.0);
a.multiply(b).execute();

Outout:

6.0
```

### Constant

define constant value.
```java
CNode a = cg.constant(2.0);
```

### Variable

define variable which can be changed in calculation.
```java
CNode b = cg.variable(2.0);
```

substitute node can change variable.
```java
Input:

CNode b = cg.variable(2.0);
CNode sub = cg.substitute(b, cg.constant(3.0));
cg.execute(sub);

System.out.println(b);

Output:

3.0
```

### Placeholder

define placeholder which has empty value and can be assigned value when calculate node.
```java
Input:

CNode a = cg.placeholder();
CNode b = cg.contant(2.0);
CNode c = a.multiply(b);

// cg.assign("node", "value") can assign "value" to "node"
c.execute(cg.assign(a, 100.0));
c.execute(cg.assign(a, 200.0));

Output:

200.0

400.0
```

### Matrix
define matrix node
```java
CNode a = cg.constant(new double[][]{{1, 1}, {1, 2}, {2, 3}});
```

operations
```java
Input:

double[][] a = {{1.0, 2.0},
                {3.0, 4.0}};
double[][] b = {{2.0, 1.0},
                {4.0, 5.0}};
CNode nodeA = cg.constant(a);   // 2 x 2 matrix
CNode nodeB = cg.constant(b);   // 2 x 2 matrix
CNode nodeC = cg.constant(3.0); // scalar

nodeA.multiply(nodeC).execute();    // a * 3.0
nodeA.multiply(nodeB).execute();    // entrywise multiply
nodeA.matMultiply(nodeB).execute(); // matrix multiply

Output:

[[3.0, 6.0],
 [9.0, 12.0]]

[[2.0, 2.0],
 [12.0, 20.0]]

[[10.0, 11.0],
 [22.0, 32.0]]

```

### Gradients

y = x^2

dy/dx = 2 x
```java
Input:

CNode x = cg.constant(2.0);
CNode y = x.activate(cg.func.SQ);
y.partialDiff(x).execute();

Output:

4.0
```

```java
Input:

double[][] a = {{1.0, 2.0},
                {3.0, 4.0}};
CNode x = cg.constant(a);
CNode y = x.activate(cg.func.SQ);
y.partialDiff(x).execute();

Output:

[[2.0, 4.0],
 [6.0, 8.0]]
```

### Activate
```java
Input:

double[][] a = {{1.0, 2.0},
                {3.0, 4.0}};
CNode x = cg.constant(a);
CNode y = x.activate(cg.func.SQ); // or cg.activate(x, cg.func.SQ).
y.execute();

Output:

[[1.0, 4.0],
 [9.0, 16.0]]
```

activate(ActivationFunction) means 行列であれば，それぞれの要素に関数を作用させる．

つまり，Aij = F(Aij)

cg.funcには，SQ, SQRTといったものが入っているが，自分で定義できる．

```java
CNode y = x.activate(
    new ActivationFunction {
        // return F(value)
        public activate(double value) {
            return value*value*value;
        }

        // return F'(value)
        public activateDiff(double value) {
            return 3 * value * value;
        }
    }
);
```

activateDiffは勾配(partialDiff)を求めるのに必要．求めないのなら，return nullでも大丈夫，

### Batch Handling

複数のNodeを同時に実行したいときは，Batch Node を用いる．
```java
CNode a, b, c, d = ...

CNode batch = cg.batch(a, b, c, d);
cg.execute(batch);
```
これで，a, b, c, dが実行される．