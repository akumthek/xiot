# xiot
this is the android code for xray machine IOT
after couple of basic workings the final state of the code focuses on creating a job schedular
With schedular, the application will keep uploading the sms s recived, without the need to start the app and press upload button as such.
all one is needed to do is start the batch job once

operation of upload is idempotent
meaning run the app any number of times, it has no adverse effect.

various important code points are marked by tags. e.g. 1.0 - empty project , 2.0 - basic job schedular works

all the best. 
