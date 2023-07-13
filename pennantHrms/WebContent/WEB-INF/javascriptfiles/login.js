document.addEventListener("DOMContentLoaded", function() {
  var loginForm = document.getElementById('login');
  var registerForm = document.getElementById('register');
  var toggleBtns = document.getElementsByClassName('toggle-btn');
  
  // Add click event listeners to toggle buttons
  for (var i = 0; i < toggleBtns.length; i++) {
    toggleBtns[i].addEventListener('click', function() {
      if (this.getAttribute('data-form') === 'login') {
        loginForm.style.left = '50px';
        registerForm.style.left = '450px';
      } else {
        loginForm.style.left = '-400px';
        registerForm.style.left = '50px';
      }
    });
  }
});
