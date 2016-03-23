all: SyncGet.class Md.class

SyncGet.class: SyncGet.java okhttp-3.2.0.jar okio-1.6.0.jar 
	javac -cp ".:*" $<

SyncGet: SyncGet.class
	java -cp ".:*" $@
#	java -cp ".:*" $(basename $< .class)

Md.class: Md.java okhttp-3.2.0.jar okio-1.6.0.jar 
	javac -cp ".:*" $<

Md: Md.class
	java -cp ".:*" $@

clean:
	rm -rf SyncGet.class Md.class
