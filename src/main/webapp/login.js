'use strict'
//==========================================================================
//----------------- Login variables ----------------------------------------
//==========================================================================
let loginFormContainer = document.getElementById("loginFormContainer");
//------------------ Employee Login ----------------------------------------
let employeeLoginForm = document.getElementById("employeeLoginForm");
let employeeNumber = document.getElementById("employeeNumber")
let employeeLoginFormUrl = "http://localhost:8080/Project1/employeelogin";
//------------------ Manager Login -----------------------------------------

//==========================================================================
//------------------ Employee Info Variables -------------------------------
//==========================================================================
let employeeData;
let employeeInfo = document.getElementById("employeeUpdateContainer");
let empVal = {};

//==========================================================================
//------------------ Manager Info Variables --------------------------------
//==========================================================================



//=========================================================================
//------------------ Event Listeners --------------------------------------
//=========================================================================

employeeLoginForm.addEventListener('submit', employeeLogin);


//=========================================================================
//---------------------- Functions ----------------------------------------
//=========================================================================
async function employeeLogin(e){
    e.preventDefault();
    

    empVal.employeeNumber = employeeNumber.value;
    console.log(JSON.stringify(empVal));
    let response = await fetch(employeeLoginFormUrl,
        { method: 'POST', body: JSON.stringify(empVal)})
        .then(response => response.text())
        .then((data)=>{
            employeeData = JSON.parse(data)
        })
        console.log(employeeData.employeeNumber)
        // employeeData = JSON.parse(response);
    // employeeData = JSON.parse(response);
    // console.log(employeeData.employeeNumber);
    // console.log(employeeData.employeeFirstName);
    // console.log(employeeData.employeeLastName);
    // console.log(employeeData.employeeEmail);

    createEmployeeInfo();
    loginFormContainer.remove();
};
//========================================================================

function createEmployeeInfo(){

    let empno = document.createElement("div");
    let empnotxt = document.createTextNode(employeeData.employeeNumber);
    empno.appendChild(empnotxt);
    let empfrstnm = document.createElement("div");
    let empfrstnmtxt = document.createTextNode(employeeData.employeeFirstName);
    empfrstnm.appendChild(empfrstnmtxt);
    let emplstnm = document.createElement("div");
    let emplstnmtxt = document.createTextNode(employeeData.employeeLastName);
    emplstnm.appendChild(emplstnmtxt);
    let empemail = document.createElement("div");
    let empemailtxt = document.createTextNode(employeeData.employeeEmail);
    empemail.appendChild(empemailtxt);


    employeeInfo.appendChild(empno);
    employeeInfo.appendChild(empfrstnm);
    employeeInfo.appendChild(emplstnm);
    employeeInfo.appendChild(empemail);

    
    // createEmployeeUpdate()
    updateEmployeeButton();
    createLogoutButton();
    createReimbursementButton();
    viewPendingRequests();

}

//=========================================================================
function updateEmployeeButton(){
    let employeeUpdateButton = document.createElement("button");
    let employeeUpdateButtonTxt = document.createTextNode("Update Employee");
    employeeUpdateButton.appendChild(employeeUpdateButtonTxt);
    employeeInfo.appendChild(employeeUpdateButton);
    employeeUpdateButton.addEventListener('click', function(){
        createEmployeeUpdateForm();
    })
}
//=========================================================================

function createLogoutButton(){
    let logoutButton = document.createElement("a");
    let logoutButtonText = document.createTextNode("Logout");
    logoutButton.setAttribute("href", "http://localhost:8080/Project1/")
    logoutButton.appendChild(logoutButtonText);
    employeeInfo.appendChild(logoutButton);
    logoutButton.addEventListener('click', function(){
        employeeInfo.remove();
    })
}
//=========================================================================
function createReimbursementButton(){
    let employeeUpdateButton = document.createElement("button");
    let employeeUpdateButtonTxt = document.createTextNode("Reimbursement Request");
    employeeUpdateButton.appendChild(employeeUpdateButtonTxt);
    employeeInfo.appendChild(employeeUpdateButton);
    employeeUpdateButton.addEventListener('click', function(){
        createEployeeReimbursementForm();
    })
}
//=========================================================================
function viewPendingRequests(){
    let employeeUpdateButton = document.createElement("button");
    let employeeUpdateButtonTxt = document.createTextNode("View Pending");
    employeeUpdateButton.appendChild(employeeUpdateButtonTxt);
    employeeInfo.appendChild(employeeUpdateButton);
    employeeUpdateButton.addEventListener('click', function(){
        showPendingReimbursements();
    })
}
//=========================================================================


function createEmployeeUpdateForm(){
//==========================================================================
//------------------ Employee Update Variables -----------------------------
//==========================================================================
let employeeUpdateContainer = document.getElementById("employeeUpdateContainer");
let employeeUpdateUrl = "http://localhost:8080/Project1/employeeupdate";
let updatedEmployeeData;
let updateEmployeeVal = {};
//--------------------------------------------------------------------
let employeeUpdateForm = document.createElement("form");
employeeUpdateForm.setAttribute("id", "employeeUpdateForm");
//--------------------------------------------------------------------
let employeeUpdateLabel = document.createElement("label");
let employeeUpdateLabelTxt = document.createTextNode("Update Info");
employeeUpdateLabel.appendChild(employeeUpdateLabelTxt);
//--------------------------------------------------------------------
let employeeUpdateFirstName = document.createElement("input");
employeeUpdateFirstName.setAttribute("type", "text");
employeeUpdateFirstName.setAttribute("name", "employeeFirstName");
employeeUpdateFirstName.setAttribute("id", "employeeFirstName");
employeeUpdateFirstName.setAttribute("placeholder", "New First Name");

//--------------------------------------------------------------------
let employeeUpdateLastname = document.createElement("input");
employeeUpdateLastname.setAttribute("type", "text");
employeeUpdateLastname.setAttribute("name", "employeeLastName");
employeeUpdateLastname.setAttribute("id", "employeeLastName");
employeeUpdateLastname.setAttribute("placeholder", "New Last Name");
//--------------------------------------------------------------------
let employeeUpdateSubmit = document.createElement("input");
employeeUpdateSubmit.setAttribute("type", "submit");
let employeeUpdateSubmitTxt = document.createTextNode("Submit");
employeeUpdateSubmit.appendChild(employeeUpdateSubmitTxt);
//--------------------------------------------------------------------


    console.log("The employeeData is now... " + JSON.stringify(employeeData));
    employeeUpdateForm.appendChild(employeeUpdateLabel);
    employeeUpdateForm.appendChild(employeeUpdateFirstName);
    employeeUpdateForm.appendChild(employeeUpdateLastname);
    employeeUpdateForm.appendChild(employeeUpdateSubmit);

    employeeUpdateContainer.appendChild(employeeUpdateForm);
//--------------------------------------------------------------------

    // employeeData.employeeFirstName = empfstnm.value;
    // employeeData.employeeLastName = emplstnm.value;
    // console.log(empfstnm.value)
    // console.log(emplstnm.value)


    employeeUpdateForm.addEventListener("submit", submit);
    let employeeForm = document.getElementById("employeeUpdateForm");
    let empfstnm = document.getElementById("employeeFirstName");
    let emplstnm = document.getElementById("employeeLastName");



    async function submit(e){
        e.preventDefault();

        employeeData.employeeFirstName = empfstnm.value;
        employeeData.employeeLastName = emplstnm.value;
        console.log(empfstnm.value)
        console.log(emplstnm.value)

        console.log(employeeData)
        await fetch(employeeUpdateUrl, {method: 'POST', body: JSON.stringify(employeeData)})
        .then(response => response.text())
        .then((data)=>{
            updatedEmployeeData = JSON.parse(data)
        })
        console.log(updatedEmployeeData.employeeFirstName);
        while (employeeInfo.hasChildNodes()) {  
            employeeInfo.removeChild(employeeInfo.firstChild);
          }
        // employeeInfo.removeChild(employeeForm);
        createEmployeeInfo();
    };
}

//========================================================================

function createEployeeReimbursementForm(){
//==========================================================================
//------------------ Request Reimbursement Variables -----------------------------
//==========================================================================
let employeeUpdateContainer = document.getElementById("employeeUpdateContainer");
let pendingReimbursementUrl = "http://localhost:8080/Project1/pendingreimbursement";
let updatedEmployeeData;
let updateEmployeeVal = {};
//--------------------------------------------------------------------
//Place this inside of the EmployeeInfo section 
let reimbursement = document.getElementById("employeeInfo");
//--------------------------------------------------------------------
let requestReimbursementContainer = document.createElement("div");
requestReimbursementContainer.setAttribute("id", "requestReimbursementContainer");
//--------------------------------------------------------------------
let requestReimbursementForm = document.createElement("form");
requestReimbursementForm.setAttribute("id", "requestReimbursementForm");
//--------------------------------------------------------------------
let amountRequested = document.createElement("input");
amountRequested.setAttribute("type", "text");
amountRequested.setAttribute("name", "amountRequested");
amountRequested.setAttribute("id", "amountRequested");
amountRequested.setAttribute("placeholder", "Amount Requested");
//--------------------------------------------------------------------
let purposeForRequest = document.createElement("input");
purposeForRequest.setAttribute("type", "text");
purposeForRequest.setAttribute("name", "purposeForRequest");
purposeForRequest.setAttribute("id", "purposeForRequest");
purposeForRequest.setAttribute("placeholder", "Purpose For Request");
//--------------------------------------------------------------------
let reimbursementRequestSubmit = document.createElement("input");
reimbursementRequestSubmit.setAttribute("type", "submit");
let reimbursementRequestSubmitTxt = document.createTextNode("Submit Reimbursement");
reimbursementRequestSubmit.appendChild(reimbursementRequestSubmitTxt);
//--------------------------------------------------------------------

    requestReimbursementForm.appendChild(amountRequested);
    requestReimbursementForm.appendChild(purposeForRequest);
    requestReimbursementForm.appendChild(reimbursementRequestSubmit);
    requestReimbursementContainer.appendChild(requestReimbursementForm);
    reimbursement.appendChild(requestReimbursementContainer);

    let reimbursementForm = document.getElementById("requestReimbursementForm");

    reimbursementForm.addEventListener("submit", submit);


    

    async function submit(e){
        e.preventDefault();
        let pendingReimbursementData = {};
        console.log("The employee data is " + JSON.stringify(employeeData))
        
        let amountRequestedValue = document.getElementById("amountRequested");
        let purposeForRequestValue = document.getElementById("purposeForRequest");

        pendingReimbursementData.employeeNumber = employeeData.employeeNumber;
        pendingReimbursementData.employeeFirstName = employeeData.employeeFirstName;
        pendingReimbursementData.amountRequested = amountRequestedValue.value;
        pendingReimbursementData.purposeForRequest = purposeForRequestValue.value;
        // console.log(empfstnm.value)
        // console.log(emplstnm.value)
        console.log("the pending reimbursement data is " + JSON.stringify(pendingReimbursementData));
        // console.log(employeeData)
        await fetch(pendingReimbursementUrl, {method: 'POST', body: JSON.stringify(pendingReimbursementData)});
        // .then(response => response.text())
        // .then((data)=>{
        //     updatedEmployeeData = JSON.parse(data)
        // })
        // console.log(updatedEmployeeData.employeeFirstName);
        // while (employeeInfo.hasChildNodes()) {  
        //     employeeInfo.removeChild(employeeInfo.firstChild);
        //   }
        // // employeeInfo.removeChild(employeeForm);
        // createEmployeeInfo();
    };
};


//========================================================================

async function showPendingReimbursements(){
    //==========================================================================
    //------------------ Show Pending Reimbursement Variables ------------------
    //==========================================================================
    let employeeUpdateContainer = document.getElementById("employeeUpdateContainer");
    let pendingReimbursementUrl = "http://localhost:8080/Project1/viewpendingreimbursement";
    let updatedEmployeeData;
    let updateEmployeeVal = {};
    //--------------------------------------------------------------------
    console.log(JSON.stringify(employeeData.employeeNumber))
    await fetch(pendingReimbursementUrl, {method: 'POST', body: JSON.stringify(employeeData.employeeNumber)});

    
        // reimbursementForm.addEventListener("submit", submit);
    
    
        
    
        async function submit(e){
            e.preventDefault();
            // let pendingReimbursementData = {};
            // console.log("The employee data is " + JSON.stringify(employeeData))
            
            // let amountRequestedValue = document.getElementById("amountRequested");
            // let purposeForRequestValue = document.getElementById("purposeForRequest");
    
            // pendingReimbursementData.employeeNumber = employeeData.employeeNumber;
            // pendingReimbursementData.employeeFirstName = employeeData.employeeFirstName;
            // pendingReimbursementData.amountRequested = amountRequestedValue.value;
            // pendingReimbursementData.purposeForRequest = purposeForRequestValue.value;
            // console.log(empfstnm.value)
            // console.log(emplstnm.value)
            console.log("the pending reimbursement data is " + JSON.stringify(pendingReimbursementData));
            // console.log(employeeData)
            await fetch(pendingReimbursementUrl, {method: 'GET'});
            // .then(response => response.text())
            // .then((data)=>{
            //     updatedEmployeeData = JSON.parse(data)
            // })
            // console.log(updatedEmployeeData.employeeFirstName);
            // while (employeeInfo.hasChildNodes()) {  
            //     employeeInfo.removeChild(employeeInfo.firstChild);
            //   }
            // // employeeInfo.removeChild(employeeForm);
            // createEmployeeInfo();
        };
    };
    
    
    //========================================================================
    // await fetch(employeeLoginFormUrl,
    // { method: 'POST', body: JSON.stringify(empVal)})
    // .then(response =>   response.json())
    // .then((data)=>{
    //     console.log(data)
    // })
//=======================================================================
    // .catch((error) => {
    //     console.error('There has been a problem with your fetch operation:', error);
    //   });

    // let response = await fetch(employeeLoginFormUrl,
    //     { method: 'POST', body: JSON.stringify(empVal)});

    // console.log(response.body.text());
    

    // console.log('after response');
    // employeeData = JSON.parse(response.json());



