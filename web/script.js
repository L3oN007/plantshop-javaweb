// !Script for navigation bar
const bar = document.getElementById('bar');
const close = document.getElementById('close');
const nav = document.getElementById('nav');

if (bar) {
    bar.addEventListener('click', () => {
        nav.classList.add('active');
    })
}

if (close) {
    bar.addEventListener('click', () => {
        nav.classList.remove('active');
    })
}

function menuToggle() {
    const toggleMenu = document.querySelector('.menu');
    toggleMenu.classList.toggle('active')
}


//!
document.querySelector('.search_icon').addEventListener('click', function () {
    document.querySelector('.wrapper').style.display = 'block';
});

document.querySelector('html').addEventListener('click', function (event) {
    if (!event.target.classList.contains('fa-search') && !event.target.classList.contains('input')) {
        document.querySelector('.wrapper').style.display = 'none';
    }
});
//
const searchIcon = document.querySelector('.search_icon');
const searchBox = document.querySelector('.wrapper');
const dropdown = document.querySelector('.dropdown');

searchIcon.addEventListener('click', function (event) {
    event.stopPropagation();
    searchBox.classList.toggle('show');
});

dropdown.addEventListener('click', function (event) {
    event.stopPropagation();
});

document.addEventListener('click', function (event) {
    if (!searchBox.contains(event.target) && !searchIcon.contains(event.target)) {
        searchBox.classList.remove('show');
    }
});



// ! Search placeholder
//let inputfield = document.getElementById('inputfield');
//let selectText = document.getElementById('selectText');
//let options = document.getElementsByClassName('options');
//
//for (option of options) {
//    option.onclick = function () {
//        selectText.innerHTML = this.innerHTML;
//        inputfield.placeholder = 'Search ' + selectText.innerHTML;
//    };
//}


// ! drop down menu
$(".default_option").click(function () {
    $(".dropdown ul").addClass("active");
});

$(".dropdown ul li").click(function () {
    var text = $(this).text();
    $(".default_option").text(text);
    $(".dropdown ul").removeClass("active");
});

function toggleDropdown() {
    const dropdownMenu = document.querySelector('.dropdown-menu');
    dropdownMenu.classList.toggle('show');
}

function selectOption(option) {
    const dropdownToggle = document.querySelector('.default_option');
    const hiddenInput = document.querySelector("input[name='searchby']");
    hiddenInput.value = option;
    dropdownToggle.innerText = "By " + option.charAt(0).toUpperCase() + option.slice(1);
    toggleDropdown();
}

document.addEventListener('click', (event) => {
    const dropdown = document.querySelector('.dropdown');
    if (!dropdown.contains(event.target)) {
        const dropdownMenu = document.querySelector('.dropdown-menu');
        dropdownMenu.classList.remove('show');
    }
});

// Toast function
function toast({ title = "", message = "", type = "info", duration = 3000 }) {
  const main = document.getElementById("toast");
  if (main) {
    const toast = document.createElement("div");

    // Auto remove toast
    const autoRemoveId = setTimeout(function () {
      main.removeChild(toast);
    }, duration + 1000);

    // Remove toast when clicked
    toast.onclick = function (e) {
      if (e.target.closest(".toast__close")) {
        main.removeChild(toast);
        clearTimeout(autoRemoveId);
      }
    };

    const icons = {
      success: "fas fa-check-circle",
      info: "fas fa-info-circle",
      warning: "fas fa-exclamation-circle",
      error: "fas fa-exclamation-circle"
    };
    const icon = icons[type];
    const delay = (duration / 1000).toFixed(2);

    toast.classList.add("toast", `toast--${type}`);
    toast.style.animation = `slideInLeft ease .3s, fadeOut linear 1s ${delay}s forwards`;

    toast.innerHTML = `
                    <div class="toast__icon">
                        <i class="${icon}"></i>
                    </div>
                    <div class="toast__body">
                        <h3 class="toast__title">${title}</h3>
                        <p class="toast__msg">${message}</p>
                    </div>
                    <div class="toast__close">
                        <i class="fas fa-times"></i>
                    </div>
                `;
    main.appendChild(toast);
  }
}
