//function for gravity equation

function calculate() {
    var myBox1 = document.getElementById('box1').value;
    var myBox2 = document.getElementById('box2').value;
    var result = document.getElementById('result');
    var myResult = myBox1 / myBox2;
    result.value = myResult;


}
//calculate force equation
function calculate2() {
    var myBox3 = document.getElementById('box3').value;
    var myBox4 = document.getElementById('box4').value;
    var myBox5 = document.getElementById('box5').value;
    var result2 = document.getElementById('result2');
    var myResult2 = ( myBox3 * myBox4)/Math.pow(myBox5,2);
    result2.value = myResult2;



}
//calculate mass equation
function calculate3() {
    var myBox6 = document.getElementById('box6').value;
    var myBox7 = document.getElementById('box7').value;
    var result3 = document.getElementById('result3');
    var myResult3 = myBox6 / myBox7;
    result3.value = myResult3;
}
//calculate mass = density*volume
function calculate4() {
    var myBox8 = document.getElementById('box8').value;
    var myBox9 = document.getElementById('box9').value;
    var result4 = document.getElementById('result4');
    var myResult4 = myBox8 * myBox9;
    result4.value = myResult4;

}
//email validation
var form  = document.getElementsByTagName('form')[0];
var email = document.getElementById('mail');
var error = document.querySelector('.error');

email.addEventListener("input", function (event) {
    // Each time the user types something, we check if the
    // email field is valid.
    if (email.validity.valid) {
        // In case there is an error message visible, if the field
        // is valid, we remove the error message.
        error.innerHTML = ""; // Reset the content of the message
        error.className = "error"; // Reset the visual state of the message
    }
}, false);
form.addEventListener("submit", function (event) {
    // Each time the user tries to send the data, we check
    // if the email field is valid.
    if (!email.validity.valid) {

        // If the field is not valid, we display a custom
        // error message.
        error.innerHTML = "Please enter a valid email address.";
        error.className = "error active";
        // And we prevent the form from being sent by canceling the event
        event.preventDefault();
    }
}, false);
//additionalnfo