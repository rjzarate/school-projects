var net = require("net");
const { join } = require("path");
var eol = require("os").EOL;

var srvr = net.createServer();
var clientList = [];

srvr.on("connection", function (client) {
  client.name = client.remoteAddress + ":" + client.remotePort;
  client.write("Welcome, " + client.name + eol);
  clientList.push(client);

  client.on("data", function (data) {
    if (String(data).charAt(0) == ":") {
      handleDirectory(data, client);
    } else {
      broadcast(data, client);
    }
  });
});

function broadcast(data, client) {
  for (var i in clientList) {
    if (client !== clientList[i]) {
      clientList[i].write(client.name + " says " + data);
    }
  }
}
function handleDirectory(data, client) {
  data = String(data).replace("\n", "");
  if (data.includes(":list")) {
    for (const i in clientList) {
      if (client != clientList[i]) {
        client.write(clientList[i].name + "\n");
      }
    }
  } else if (data.includes(":rename")) {
    client.name = data.split(" ")[1];
    client.write(
      "Your name has been updated to: " + data.split(" ")[1] + "\n"
    );
  } else if (data.includes(":private")) {
    const dataList = data.split(" ");
    for (const i in clientList) {
      if (clientList[i].name == dataList[1]) {
        const receiver = clientList[i];
        receiver.write(
          client.name + " privately says " + dataList.slice(2).join(" ") + "\n"
        );
        return;
      }
    }
    client.write("Message not sent, invalid recipient\n");
  } else {
    client.write("Invalid command\n");
  }
}

srvr.listen(9000);
