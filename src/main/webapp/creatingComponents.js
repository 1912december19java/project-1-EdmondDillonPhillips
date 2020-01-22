'use strict'

let loginFormContainer = document.getElementById("loginContainer");

let employeeForm = document.createElement('form');
let employeeLabel = document.createElement('label');
let employeeSubmit = document.createElement('input');
let employeeNumberInput = document.createElement('input');

let managerForm = document.createElement('form');
let managerLabel = document.createElement('label');
let managerSubmit = document.createElement('input');
let managerNumberInput = document.createElement('input');

function createLoginComponent(){
    // loginFormContainer.setAttribute("class", "loginContainer");

    employeeForm.setAttribute("id", "employeeLoginForm");
    employeeLabel.setAttribute("for", "employeeNumber");
    employeeLabel.innerText = "Employee Number";
    employeeNumberInput.setAttribute("name", "employeeNumber");
    employeeNumberInput.setAttribute("id", "employeeNumber");
    employeeSubmit = document.setAttribute("type", "submit");

    loginFormContainer.appendChild(employeeForm);
    employeeForm.appendChild(employeeLabel);
    employeeForm.appendChild(employeeNumberInput);
    employeeForm.appendChild(employeeSubmit);



    managerForm.setAttribute('id', "managerLoginForm");
    managerLabel.setAttribute('for', "managerNumber");
    managerLabel.innerHTML = "Manager Number";
    managerNumberInput.setAttribute("name", "managerNumber");
    managerNumberInput.setAttribute("id", "managerNumber");
    managerSubmit = document.setAttribute("type", "submit");

    loginFormContainer.appendChild(managerForm);
    managerForm.appendChild(managerLabel);
    managerForm.appendChild(managerNumberInput);
    managerForm.appendChild(managerSubmit);
}

export {createLoginComponent}