call mvn clean
call mvn compile
call mvn war:war

cd "C:\Users\A0C5ZZ\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\webapps"
rm -rf *.*
copy C:\Users\A0C5ZZ\workspace\newsFiddle\target\*.war .
cd "C:\Users\A0C5ZZ\workspace\newsFiddle"