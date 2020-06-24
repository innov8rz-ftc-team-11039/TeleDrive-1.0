# TeleDrive

Best performance.
Low Latency.

Enabling remote Driver-Controlled TeleOp over the internet for FIRST Tech Challenge teams.

<!-- <a href="http://www.youtube.com/watch?feature=player_embedded&v=gdEGrdmpl5o" target="_blank"><img src="http://img.youtube.com/vi/gdEGrdmpl5o/0.jpg" alt="Unable to Load Image" width="480" height="360" border="0" /></a> -->

# About TeleDrive

The COVID-19 pandemic left FIRST Tech Challenge competitions, scrimmages, and team driver practice in the dark. Because of local restrictions, many teams use online resources like Zoom to communicate and start preparing for the next season. However, there still isn't a solution to being able to practice driving the robot as well as coordinating competitions and scrimmages - all remotely... until now! TeleDrive is a simple, but powerful tool that allows teams to control their robot from the comfort of their homes. Using this, competitions can be run remotely and teams can drive their robot without having to worry about personal health and safety. Our program uses simple commands to bring low-latency and high-performance control, just as if controlling your robot on the field.

All of this is able to happen within 1/40 of a second, bringing the most performance with the least latency.

Wondering how we did it? Check out our blog post for more info: <a href="http://www.innov8rz.net/blog/software/teledrive" target="_blank">TeleDrive Blog Post</a>

# Install and Setup: Remote Robot Control

First, you must choose a port that will be used by the Driver Controller computer ("Host Port") and another port for the robot to listen on ("Robot Port"). 

#### Note: A port is an integer number

There are two forms of installation of TeleDrive on your computer. In all cases, you would only install one of the following versions. The Driver Controller Side Setup is for the computer that is connected to the Gamepad via USB and will send the gamepad controls over the Internet to the Host Computer. The other side, the Host Computer Setup, is the computer near the robot which is relaying the commands it gets from the Driver Controller Side and passes it to the robot.

To relay the commands to the robot, you must follow the FTC Robot Controller App Setup to enable UDP listening on the robot to move when the Driver Controller side sends commands.

## Driver Controller Side Setup

The Driver Controller Side will be on the driver(s) computers. To install the part that sends commands, download the TeleDrive executable file for your computer from the Releases tab on the right side. Now that you have downloaded it, running it is just as simple. All you have to do is go to Command Prompt (Windows) or Terminal (Mac) and go to the directory where the TeleDrive_Driver executable file was installed. Then type:

```TeleDrive_Driver.exe <Public IPv4 address of Host Computer> <Host Port>``` (Windows)

or ```./TeleDrive_Driver <Public IPv4 address of Host Computer> <Host Port>``` (Mac). 

You must use the IPv4 Public Address of the Host computer, otherwise it would not work.

## Host Computer Setup

Setting up the Host has been made very simple. All you have to do is install the ```TeleDrive_Host.exe```, an executable file. Now, connect a USB WiFi Adapter on the host computer. Connect WiFi 2 to the Robot Controller or Control Hub and make sure that WiFi 1 is connected to the correct router in which port forwarding is enable (more about Port Forwarding in the next section). Then you must call the execuable file, by using Command Prompt or Terminal. Go to the directory where you installed the ```TeleDrive_Host.exe``` file and then type ```TeleDrive_Host.exe <Host Port> <Robot IP address> <Robot Port>``` on Windows and ```./TeleDrive_Host.exe <Host Port> <Robot IP address> <Robot Port>``` for Mac. Now, your host is ready to recieve commands from the Driver Controller(s).

## Setup Port Forwarding on WiFi router

To allow the driver controller side to send commands to the host computer, you must allow port forwarding the WiFi router that the host computer is connected to. This is done by loging in to your WiFi router, locate the port forwarding options, enable Port Forwarding, and set the following: External Port, Local IP, Local Port, and protocol to UDP. External Port, Local IP, and Local Port are different between computers so make sure to check it before hand.

## FTC Robot Controller App Setup

To setup the FTC Robot Controller to be ready to parse all of the data sent from the Driver Controller Computers, you simply need to download the ```TeleDrive.java``` file and put it in the ```TeamCode``` part of your Robot Controller project where you would usually write your code. Now, open your TeleOp class and instead of extending ```Opmode```, you can extend our TeleDrive class. Then, to make sure that you enable the full functionality of TeleDrive, you must say ```super._____()``` in every override method of the superclass. For example, in the ```init``` override method, you would put ```super.init()``` and for the ```loop```, you would put ```super.loop()```, and so on. **Not calling the method in the superclass would not enable TeleDrive's UDP listening functionality**. The next important step is to change the local IP address of the Control Hub or Robot Controller phone which can be done by clicking on "Program and Manage" on the Driver Station phone and copy the IP address into the address variable in TeleDrive.java at line 303 and change the port any you would like (default is 11039). Your robot is now ready to listen to commands coming from the Host Computer.

# Install and Setup: Video Live Stream of Playing Field

Video Live Stream is done using an industry leader in low latency live streaming: Parsec Gaming. **The host computer for this application (the one connected to webcam and is streaming video) must be Windows**. Client computers, however, can be either Windows or Mac. 

## Parsec Host Setup

To set up the Parsec host on your Windows computer, go to <a href="https://parsecgaming.com/downloads/" target="_blank">Parsec Downloads</a> and click on the Windows Operating System. Once it is done installing, create and verify an account and you are ready to stream! 

#### Note: To start a live stream quicker, make the accounts that are on the Client computers as a "Parsec friend" and you can quickly accept them into your live stream.

## Parsec Client Setup

To set up the Parsec client on your computer, go to <a href="https://parsecgaming.com/downloads/" target="_blank">Parsec Downloads</a> and click on the corresponding operating system. Once it is done installing, create and verify an account and you are ready to join a live stream! 

#### Note: To join a live stream quicker, become a "Parsec friend" with the account on the Host computer and you can quickly join into their live stream.

## Communication

**Parsec, unfortunately, does not allow audio communication in its application**. However, other reliable communication methods include Discord calls, Phone calls, and more. Some services like Zoom may have more latency than others.

# Common Errors

## Port #### is currently in use on your machine. Please try a different port.

This is most likely the only error you would encounter. In this case, you must change the the Host Port to another integer number as the Host computer is already using that port for another function. **Make sure you change the port on both the Driver Controller side and the Host side when calling the .exe file**

## Nothing happens when I call all of the .exe files and the Robot Controller is running

Make sure to check if Port Forwarding is enabled on your WiFi router and that the ports and protocol are all correct (see <a href="https://github.com/innov8rz-ftc-team-11039/TeleDrive/blob/master/README.md#setup-port-forwarding-on-wifi-router" target="_blank">Setup Port Forwarding on WiFi router</a>). Another issue may be that the ports and IP addresses may be inconsistent (see <a href="https://github.com/innov8rz-ftc-team-11039/TeleDrive#install-and-setup-remote-robot-control" target="_blank">Install and Setup: Remote Robot Control</a>). You can also check if you have correctly entered in the ports as integer numbers (see <a href="https://github.com/innov8rz-ftc-team-11039/TeleDrive/blob/master/README.md#note-a-port-is-an-integer-number" target="_blank">Port Setup</a>)

## I cannot host a Parsec server

Parsec servers only run on Windows computers, so if you are using a Mac, it wouldn't be allowed. Clients, on the other hand, can have any operating system.

# Contributors

## Developers

Avikam Chauhan

Mihir Chauhan

## Testers

Mathew Joseph

© Innov8rz FTC Team 11039 | All Rights Reserved 2020
