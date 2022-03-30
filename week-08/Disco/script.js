const button = document.querySelector("#button");

const input = document.querySelector("#message-input");

let message = "";

let messageCapture = (event) => {
  if (event.keyCode === 13) {
    message = input.value;
  }
};

let messageLog = () => {
  console.log(message);
};

button.addEventListener("click", messageLog);

input.addEventListener("keydown", messageCapture);

// let funStuff = (eventObject) => {
//   console.log(eventObject);
//   console.log("From the left: ", eventObject.clientX + "px");
//   alert("From the top: " + eventObject.clientY + "px");
// };

// button.addEventListener("click", funStuff);
