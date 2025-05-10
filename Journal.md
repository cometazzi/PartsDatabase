# Journal

Document project progress, the development process, accomplishments, snags, and time spent on this class. You may use whatever format suits you, as long as this information is shared.

[Time Log](TimeLog.md)

### Week 1 - Spring 2025
1/19/2025

Tasks Completed:
* Chose a project goal
* Created this repository
* Wrote problem statement
* Started documenting the project

### Week 2 
1/26/2025

### Week 3
2/4/2025

* Added missing files (Journal.md, Readme.md)
* Created screen design, hashed out some logistical choices
* Hashed out some illogistical choices as well.

### Week 4
2/10/2025

Some thoughts, for better or for worse:
* Transistor Table: image_url, part_num, descr ("BJT NPN Small Signal Transistor"), qty, package, cost, vendor, datasheet_url
* Chipamp Table: image_url, part_num, descr ("480mW Audio Amplifier IC"), qty, package, cost, vendor datasheet_url
* Linear IC Table: image_url, part_num, descr ("JFET Input Dual Operational Amplifier"), qty, package, cost, vendor, datasheet_url
* Logic IC Table: image_url, part_num, descr ("CMOS Input Hex Buffer / Line Driver"), qty, package, cost, vendor, datasheet_url
* Diode Table: image_url, part_num, descr ("Vintage NOS Germanium Diode"), qty, package, cost, vendor, datasheet_url
* Capacitor Table: image_url, value, descr ("Silver Mica 500V Capacitor"), qty, package (radial, axial), vendor, datasheet_url
* Resistor Table: image_url, value, descr ("1/2W Carbon Film Resistor"), qty, package (all radial, maybe not?), cost
* Other Table: image_url, descr ("Hall Effects Sensor"), qty, mounting_style, cost, vendor, datasheet_url

Something to consider, not all items have datasheets, like resistors, knobs, switches, etc.  The "datasheet_url" for these items
  would instead point to a non-working button that says "no datasheet" or similar.

Also, this is a LOT of data to have to compile and type in.  Maybe some of these fields aren't necessary, like vendor.

## Week 5
2/17/2025

* Mostly worked on the week's work, not the project

## Week 6
2/24/2025

* Scramble to get project ready to show for peer review
* Scramble also to prepare for Checkpoint #2
* Beanstalk is no less fidgety than it was 4 years ago.

## Week 7
3/3/2025

* Added Cognito to the project, but it doesn't work. Error message is completely unhelpful and the logs are behind a price tier.
* Fixed first error, now getting a 500 from the controller
* Fixed 500 with Paula's help, but now the previous error has happened.

## Week 8
3/10/2025

* There seems to be something silly going on with an underscore in the Cognito pool identifier.
* It looks like whether I have an underscore or not is what makes a difference as to whether it works locally or in beanstalk.


## Spring Break
3/17/2025

* Rebuilt entire database.  Changed all the tables, added some, and removed a few.
* Trying to keep the scope of this project attainable.
* Still having issues with Cognito.
* 
## Week 9
3/24/2025

* Still having issues with Cognito.  It looks like I'll have to use a different poolID for local and AWS
* Restful stuff looks simpler than I expected, however Digikey's and Mouser's API is much more complex

## Week 10
3/31/2025

* Still stuck on Cognito, now stuck web API stuff too.  Google isn't much help.
* Mouser's documentation is wildly out of date.
* Digikey gave me a client ID and secret, but for some reason they fail to authenticate.  Emailed support

## Week 11
4/7/2025

* No change on anything, doing Team project

## Week 12 
4/14/2025

* Team Project, no progress (recording video for team project)

## Week 13
4/21/2025

* Finally had a breakthrough with the Mouser API.
* No response from Digikey, so abandoning
* Implemented Generic Dao, and removed all other Daos

## Week 14
4/28/2025

* Implemented Mouser API
* Created new controllers for <part>MarketDetails, and associated jsps

## Week 15
5/5/2025

* Finalized all jsps (lots of small issues everywhere)
* Tested out everything, practiced for video
* Recorded videos multiple times.  Both ran over each time, but shortest so far have been posted.
