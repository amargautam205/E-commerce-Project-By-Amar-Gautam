const paymentStart = () => {

console.log("payment started..");

   const amount = document.getElementById("totalAmountHidden").value;

    alert(amount);

    if (amount == 0 || amount == null) {
        alert("Amount is required!!");
        return;
    }

  $.ajax({
        url:'/createOrder',
        data: JSON.stringify({ amount: amount, info: 'order_request' }),
        contentType: 'application/json',
        type: 'POST',
        dataType: 'json',
        success: function (response) {
            // Invoked when success
            console.log(response);
        },
        error: function (error) {
            // Invoked when error
            console.log(error);
        }
    });
 };