import ballerina/io;

funticon printString(){
io:println("Hello!!")
}
function printValue(string value) {
    io:println(value);
}

function add(int a, int b) returns (int) {
    return a + b;
}
function main(string... args) {
	printString();
    printValue("Hello World!!");
    int result = add(2, 3);
    io:println(result);
}
