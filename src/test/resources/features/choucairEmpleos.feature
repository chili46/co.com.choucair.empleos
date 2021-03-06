  #autor :Luis Fernando Silva Chilito
  @Tag0
  Feature: Choucair module jobs
    as a user I want to enter choucair jobs
    To perform a search on available jobs.

    @SearchByKeyWord
    Scenario: Search
      Given that Luis wants to access choucair jobs
      When he performs the search on the page
        | keyword     | location |
        | Performance | medellin |
      Then he verifies that the text searched is displayed on the screen
        | result      |
        | Performance |

    @ApplyToJob
    Scenario: Sign up for work
      Given that Luis wants to join performance work
      When he  fills  the form
        | name                        | email                    | phone      | studies                | experience | knowAboutAutomation | wageAspiration | availability | additionalMessage |
        | Luis Fernando Silva Chilito | luisfsilva4664@gmail.com | 3146510803 | Ingeniería de Sistemas | Ninguna    | no                  | 1.800.000      | Inmediata    | Regards           |
      Then he verifies that the text please verify the captcha is displayed on the screen
        | resultText                    |
        | Por favor verifica el captcha |

    @SearchCharacter
    Scenario: Search word out of context
      Given that Luis wants search a word in the section jobs
      When he write the word DF
      Then he sees the text No hay trabajos correspondientes a tu búsqueda

    @SearchWordOfRequiredToWork
    Scenario: Search for a word that is required to apply to work
      Given that Luis wants search a word in the section jobs
      When he write the word medico
      Then he sees the text No hay trabajos correspondientes a tu búsqueda

    @SearchSpecialCharacter
    Scenario: Search for a character
      Given that Luis wants search a word in the section jobs
      When he write the word +
      Then he sees the text No hay trabajos correspondientes a tu búsqueda

    @SearchBothFields
    Scenario: Find a work with location
      Given that Luis wants search a work in the section jobs with both field
      When he write the words
        | keyword | location |
        | pruebas | bogota   |
      Then he verifies that the keyword pruebas is displayed in the screen
      And the city bogotá displayed in the screen

    @Manual
    Scenario: Text
      Given that Luis wants to verify the correct use of spelling
      When he checks the correct use of spelling
      Then he sees that it is well written

    @Manual
    Scenario: Redirection (Link)
      Given that Luis wants to verify the correct redirection of the links
      When he clicks on the link
      Then he sees that it takes him to the right page


