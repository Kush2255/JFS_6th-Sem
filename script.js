let subjects = document.querySelectorAll(".subject-option input[type='checkbox']");
let totalBox = document.getElementById("totalAmount");
let form = document.querySelector(".registration-form");
let summaryBox = document.getElementById("submissionSummary");

subjects.forEach(item => {
    item.addEventListener("change", () => {
        let total = 0;
        subjects.forEach(sub => {
            if (sub.checked) {
                total += parseInt(sub.dataset.price);
            }
        });
        totalBox.innerText = total;
    });
});

form.addEventListener("submit", function(e) {
    e.preventDefault();

    let selectedSubjects = [];
    let totalFee = 0;

    subjects.forEach(sub => {
        if (sub.checked) {
            let subjectName = sub.nextElementSibling.innerText.trim();
            selectedSubjects.push(subjectName);
            totalFee += parseInt(sub.dataset.price);
        }
    });

    if (selectedSubjects.length === 0) {
        alert("Please select at least one subject.");
        return;
    }

    let studentName = document.getElementById("studentName").value.trim();
    if (!studentName) {
        alert("Please enter your name.");
        return;
    }

    let message =
        "Student Name: " + studentName + "\n\n" +
        "Selected Subjects: " + selectedSubjects.join(", ") + "\n" +
        "Total Fee: $" + totalFee;

    alert(message);

    summaryBox.innerHTML = `
        <p><strong>Student Name:</strong> ${studentName}</p>
        <p><strong>Selected Subjects:</strong> ${selectedSubjects.join(", ")}</p>
        <p><strong>Total Fee:</strong> $${totalFee}</p>
    `;
});