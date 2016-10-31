# Auto Update Javadoc

if [ "$TRAVIS_REPO_SLUG" == "ReadyTalk/swt-bling" ] && [ "$TRAVIS_JDK_VERSION" == "oraclejdk7" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then
    echo -e "Publishing javadoc...\n"
    cp -R build/docs/javadoc $HOME/javadoc-latest
    cd $HOME
    git config --global user.email "travis@travis-ci.org"
    git config --global user.name "travis-ci"
