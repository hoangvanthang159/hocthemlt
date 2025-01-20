const quizes = [
    {
      id: 1,
      question: "1 + 1 = ?",
      answers: [1, 2, 3, 4],
    },
    {
      id: 2,
      question: "2 + 2 = ?",
      answers: [2, 3, 4, 5],
    },
    {
      id: 3,
      question: "3 + 3 = ?",
      answers: [3, 4, 5, 6],
    },
  ];
  
  
  function randomAnswer() {
    quizes.forEach((quiz) => {
      const radioButtons = document.querySelectorAll(`input[name="${quiz.id}"]`);
      radioButtons.forEach((radio) => {
        radio.checked = false;
      });
      const randomIndex = Math.floor(Math.random() * radioButtons.length);
      radioButtons[randomIndex].checked = true; 
    });
  }
  
  document.getElementById("btn").addEventListener("click", randomAnswer);