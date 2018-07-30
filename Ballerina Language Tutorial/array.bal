import ballerina/io;

function main(string... args){

	int []a1 = {1,2,3,4,5};
	io:println(lengthof a1);
	a1[10]=10;
	io:println(lengthof a1);
	
}