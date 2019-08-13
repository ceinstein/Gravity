DEFAULTR=10
DEFAULTC=10
all:
	javac *.java

clean:
	rm -rf *.class
	rm -rf *~

run:
	java Gravity ${DEFAULTR} ${DEFAULTC}


