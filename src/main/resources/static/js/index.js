const theaterBox = document.querySelector(".theater");
const movieBox = document.querySelector(".movie");
const timeBox = document.querySelector(".time");
const seatBox = document.querySelector(".seat");
const reservationBox = document.querySelector(".reservation");

const putIntoBox = (content, box) => {
    const tempDiv = document.createElement("div");
    tempDiv.innerText = content;
    box.appendChild(tempDiv);
}

const move = (e) => {
    window.location.href = "/reservation/" + e.target.getAttribute("data-id");
}
const makeReservationButton = (content, box) => {
    const tempButton = document.createElement("button");
    tempButton.innerText = "예약하기";
    tempButton.setAttribute("data-id", content);
    tempButton.onclick = move;
    box.appendChild(tempButton);
}

function init() {
    fetch(
    '/movie/all', {
        method: 'GET'
    }).then((response) => {
    alert("방문해주셔서 감사합니다.");
    return response.json();
    }).then((json) => {
        json.forEach((el) => {
            putIntoBox(el.roomNo, theaterBox);
            putIntoBox(el.movieName, movieBox);
            putIntoBox(el.movieTime, timeBox);
            putIntoBox(parseInt(el.totalSeats - el.reservedSeats) + "(" + el.totalSeats + ")", seatBox);
            makeReservationButton(el.scheduleId, reservationBox);
        })
    });
}
init();
