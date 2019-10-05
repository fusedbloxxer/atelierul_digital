#language: ro
Funcționalitate: Formular Contact

  Structură scenariu: Contact CS

    Dat fiind Deschid pagina "http://automationpractice.com/index.php"
    Când Dau click pe "Contact us"
    Și Selectez Subject Heading "<subject heading>"
    Și Introduc adresa de email "<email address>"
    Și Introduc mesajul "<message text>"
    Și Dau click pe "Send"
    Atunci Success message "<success message>" appears

    Exemple:
      | subject heading  | email address         | message text | success message                                      |
      | Customer service | test@devschooling.com | text         | Your message has been successfully sent to our team. |
      | Webmaster        | test@devschooling.com | text         | Your message has been successfully sent to our team. |