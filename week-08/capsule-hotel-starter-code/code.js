const CAPSULE_COUNT = 100;

const bookingForm = document.querySelector("#booking-form");

const guestNameInput = document.querySelector("#guest");

const capsuleCheckIn = document.querySelector("#bookingCapsule");

let guestName = "";

let capsuleNumber = 0;

const bookAGuest = (event) => {
  event.preventDefault();
  // #capsuleLabel + capsuleNumber
  // #guest + capsuleNumber
  const capsuleGuest = document.querySelector("#guest" + capsuleNumber);
  const capsuleBubble = document.querySelector("#capsuleLabel" + capsuleNumber);
  capsuleBubble.classList.capsuleGuest.innerHTML = guestName;

  guestName = "";
};

const captureName = (event) => {
  if (
    (event.keyCode >= 65 && event.keyCode <= 90) ||
    event.keyCode === 109 ||
    event.keyCode === 32
  ) {
    guestName += event.key;
  }
};

const captureCapsule = (event) => {
  if (event.keyCode >= 48 && event.keyCode <= 57) {
    capsuleNumber += event.key;
  }
};

bookingForm.addEventListener("submit", bookAGuest);

guestNameInput.addEventListener("keydown", captureName);

capsuleCheckIn.addEventListener("keydown", captureCapsule);

function init() {
  const capsuleContainer = document.getElementById("capsules");
  let html = "";
  for (let i = 0; i < CAPSULE_COUNT; i++) {
    html += `<div>
            <span id="capsuleLabel${
              i + 1
            }" class="badge badge-pill badge-success">Capsule #${i + 1}</span>
            &nbsp;<span id="guest${i + 1}">Unoccupied</span>
        </div>`;
  }
  capsuleContainer.innerHTML = html;
}

/*
const book = document.querySelector("#Book");

const checkout = document.querySelector("#checkout");

const guestInput = document.querySelector("#guest");

const capsuleNumberInput = document.querySelector("#bookingCapsule");

const capsuleCheckoutNumber = document.querySelector("#checkOutCapsule");

let message = "";
let capsuleNumber = 0;

let guestGetter = (event) => {};

let capsuleGetter = (event) => {};

let guestCapsuleInputter = (event) => {
  message = guestInput.value;
  capsuleNumber = capsuleNumberInput.value - 1;

  let capsule = document.getElementById(`#guest${capsuleNumber}`);
  capsule.innerHTML = message;
};

book.addEventListener("click", guestCapsuleInputter);

let guestCheckout = (event) => {
  checkoutMessage = "Unoccupied";
  capsuleNumber = capsuleCheckoutNumber.value;

  let capsule = document.querySelector(`#guest${capsuleNumber}`);

  capsule.innerHTML = checkoutMessage;
};

book.addEventListener("click", guestGetter, guestCapsuleInputter);
*/

init();
