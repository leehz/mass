all: SyncGet.class SyncGet

SyncGet.class: SyncGet.java okhttp-3.2.0.jar okio-1.6.0.jar 
	javac -cp ".:*" $<

SyncGet: SyncGet.class
	java -cp ".:*" $@
#	java -cp ".:*" $(basename $< .class)

clean:
	rm -rf SyncGet.class
