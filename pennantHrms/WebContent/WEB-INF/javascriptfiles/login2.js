document.addEventListener("DOMContentLoaded", function() {
  var modal = document.getElementById('login-form');
  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
});
