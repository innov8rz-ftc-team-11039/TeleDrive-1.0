# TeleDrive

Best performance.
Low Latency.

Enabling remote Driver-Controlled TeleOp over the internet for FIRST Tech Challenge teams.

<a href="http://www.youtube.com/watch?feature=player_embedded&v=gdEGrdmpl5o" target="_blank"><img src="http://img.youtube.com/vi/gdEGrdmpl5o/0.jpg" alt="Unable to Load Image" width="480" height="360" border="0" /></a>

# About TeleDrive

The COVID-19 pandemic left FIRST Tech Challenge competitions, scrimmages, and team driver practice in the dark. Because of local restrictions, many teams use online resources like Zoom to communicate and start preparing for the next season. However, there still isn't a solution to being able to practice driving the robot as well as coordinating competitions and scrimmages - all remotely... until now! TeleDrive is a simple, but powerful tool that allows teams to control their robot from the comfort of their homes. Using this, competitions can be run remotely and teams can drive their robot without having to worry about personal health and safety. Our program uses simple commands to bring low-latency and high-performance control, just as if controlling your robot on the field.

All of this is able to happen within 1/40 of a second, bringing the most performance with the least latency.

Wondering how we did it? Check out our blog post for more info: <a href="http://www.innov8rz.net/blog/software/teledrive" target="_blank">TeleDrive Blog Post</a>

# Installation, Setup, and Usage

  ### Part 1: Integrate ```TeleDrive.java``` with your existing TeleOp programs
  
  1. Simply download ```TeleDrive.java```, and copy it into your ```TeamCode``` folder
  2. Change your TeleOp program(s) to extend the ```TeleDrive``` class
  3. For each OpMode function (init, init_loop, start, loop, stop) in your TeleOp class, call super.func() at the beginning of that function. **This is required, and not calling the method in the superclass would not allow TeleDrive to function properly.** (Ex: in the loop() function, you must call super.loop() at the beginning)
  4. Using your Driver Station phone, navigate to the "Program and Manage" menu, and find the local IP address of the Control Hub or Robot Controller phone
  5. On line 303 in ```TeleDrive.java```, replace the existing IP address with the IP address you found in Step 4
  6. Optional: change the local port in ```TeleDrive.java``` at line 303 (default is 11039) **Note: a port is an integer number.**

  ### Part 2: Setup the Host Computer (a computer that's in the same physical location as the robot) with ```TeleDrive_Host```

  1. On the Host Computer, download ```TeleDrive_Host.exe``` (for Windows) or ```TeleDrive_Host``` (for Mac)
  2. Plug in a USB WiFi adapter to the Host Computer
  3. Connect the secondary WiFi (WiFi 2) to the Control Hub or Robot Controller, and ensure that WiFi 1 is connected to your local router
  4. Start the executable file by typing ```TeleDrive_Host.exe <Host Port> <Robot IP address> <Robot Port>``` (in Command Prompt on Windows) or ```./TeleDrive_Host <Host Port> <Robot IP address> <Robot Port>``` (in Terminal on Mac).
  
  Now, your host is ready to recieve commands from the Driver Controller(s).
  
  ### Part 3: Setup Port Forwarding on the Host Computer's WiFi router

  To allow the driver controller side to send commands to the host computer, you must allow port forwarding the WiFi router that the host computer is connected to. This is done by loging in to your WiFi router, locating the port forwarding options, enabling Port Forwarding, and setting the following: 
  
  * External Port: Pick a port that other users can connect to via the internet
  * Local IP: Your Host Computer's local IP address (use ipconfig or ifconfig to find this)
  * Local Port: This is the first port that you typed in the previous part (Ex: ```./TeleDrive_Host 11039 "192.168.43.1" 12345``` --> 11039)
  * Protocol: UDP

  ### Part 4: Setup the Driver Computer (a computer that is used to remotely control the robot) with ```TeleDrive_Driver```
  
  1. On the Host Computer, download ```TeleDrive_Driver.exe``` (for Windows) or ```TeleDrive_Driver``` (for Mac)
  2. Plug in a USB gamepad (ex. Logitech F310)
  3. Start the executable file by typing ```TeleDrive_Driver.exe <Public IPv4 address of Host Computer> <Host Port>``` (in Command Prompt on Windows) or ```./TeleDrive_Driver <Public IPv4 address of Host Computer> <Host Port>``` (in Terminal on Mac).

**You must use the public IPv4 address of the Host Computer, otherwise it would not work.**

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
