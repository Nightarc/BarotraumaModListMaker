# BarotraumaModListMaker
A simple Java application to parse Barotrauma mod load order list from steam collection URL so you don't have to re-arrange them manually when installing a collection.

### How to use
- **1. Clone repository and compile with java SDK or your IDE.**
  ```
  git clone https://github.com/Nightarc/BarotraumaModListMaker.git
  ```
  **OR**
- **1. Download latest version fron [Releases](https://github.com/Nightarc/BarotraumaModListMaker/releases)**
- **2. Start**
  
    For launching you need either to
  + Run jar file from terminal or command prompt like this:  
        ```
        java -jar BarotraumaModListMaker.jar *Steam Collection URL*
        ```
  + Create a text file, parse previous command into it, rename it to .bat extension and launch it (if you are a Windows user).
  + 
- **3. Result**
  - Then, it should create a .xml file with modlist's name which you can import into Barotrauma. (Don't forget to subscribe to collection in Steam)
