const days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
const timeSlot = "9:30 AM - 12:30 PM";

let timetable = {
    Monday: "",
    Tuesday: "",
    Wednesday: "",
    Thursday: "",
    Friday: "",
    Saturday: ""
};

const tableBody = document.getElementById("timetable-body");

function renderTable() {
    tableBody.innerHTML = "";

    days.forEach(day => {
        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${day}</td>
            <td>${timeSlot}</td>
            <td>${timetable[day] || "-"}</td>
            <td>
                ${
                    timetable[day]
                        ? `<button class="delete-btn" onclick="deleteSubject('${day}')">Delete</button>`
                        : "-"
                }
            </td>
        `;

        tableBody.appendChild(row);
    });
}

function addSubject() {
    const day = document.getElementById("day").value;
    const subject = document.getElementById("subject").value.trim();

    if (!day || !subject) {
        alert("Please select day and enter subject");
        return;
    }

    timetable[day] = subject;
    renderTable();

    document.getElementById("subject").value = "";
}

function deleteSubject(day) {
    timetable[day] = "";
    renderTable();
}

renderTable();
