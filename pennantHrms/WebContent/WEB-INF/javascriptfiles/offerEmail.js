  let popup = document.getElementById("popup");

    function openPopup(event) {
        event.preventDefault(); // Prevent the default form submission

        // Show the pop-up
        popup.classList.add("open-popup");

        // Submit the form after a delay of 1 second (adjust the delay if needed)
        setTimeout(() => {
            document.getElementById("sendOfferForm").submit();
        }, 1000);
    }

    function closePopup() {
        popup.classList.remove("open-popup");
    }