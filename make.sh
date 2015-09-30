echo “RSSFiddle Build and Deploy”
mvn clean
mvn compile
mvn war:war
rm -rf ~/Documents/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/*.*
cp ./target/*.war ~/Documents/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps
