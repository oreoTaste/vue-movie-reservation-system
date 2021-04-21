const theaterBox = document.querySelector(".theater");
const movieBox = document.querySelector(".movie");
const timeBox = document.querySelector(".time");
const seatBox = document.querySelector(".seat");

const putIntoBox = (content, box) => {
    const tempDiv = document.createElement("div");
    tempDiv.innerText = content;
    box.appendChild(tempDiv);
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
            console.log(el.scheduleId, el.roomNo, el.movieName, el.movieTime, el.price, el.seatColumn, el.seatRow);
            putIntoBox(el.roomNo, theaterBox);
            putIntoBox(el.movieName, movieBox);
            putIntoBox(el.movieTime, timeBox);
            putIntoBox(parseInt(el.seatColumn) * parseInt(el.seatRow), seatBox);
        })
    });
}
init();