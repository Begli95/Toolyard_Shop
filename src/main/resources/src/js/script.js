let slideIndex = 0;
const slides = document.querySelectorAll('.promo__slide');
const counter = document.querySelector('.promo__counter-number');
const prevBtn = document.querySelector('.promo__prev');
const nextBtn = document.querySelector('.promo__next');

function showSlides(index) {
  counter.textContent = `${index + 1} / `;
}

function setActiveSlide(index) {
  slides.forEach((slide, idx) => {
    const positions = ['promo__slide-prev', 'promo__slide-next', 'promo__slide__active'];
    positions.forEach(pos => slide.classList.remove(pos));
    
    if (idx === index) {
      slide.classList.add('promo__slide__active');
    } else if (idx === (index - 1 + slides.length) % slides.length) {
      slide.classList.add('promo__slide-prev');
    } else if (idx === (index + 1) % slides.length) {
      slide.classList.add('promo__slide-next');
    }
  });
}

function nextSlide() {
  slideIndex = (slideIndex + 1) % slides.length;
  setActiveSlide(slideIndex);
  showSlides(slideIndex);
}

function prevSlide() {
  slideIndex = (slideIndex - 1 + slides.length) % slides.length;
  setActiveSlide(slideIndex);
  showSlides(slideIndex);
}

showSlides(slideIndex);

prevBtn.addEventListener('click', prevSlide);
nextBtn.addEventListener('click', nextSlide);


const hearts = document.querySelectorAll('.sale__list-heart');

hearts.forEach((heart) => {
  heart.addEventListener('click', function() {
    heart.classList.toggle('sale__list-heart_active');
  });
});

const salebuttons = document.querySelectorAll('.sale__list-btn');

salebuttons.forEach((salebutton) => {
  salebutton.addEventListener('click', function() {
    salebutton.classList.toggle('sale__list-btn_active');
  });
});

