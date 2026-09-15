Feature: Test du site web ParaBank
  Background:
    Given Visiter le site web "https://parabank.parasoft.com/"

  Scenario: creation de compte 
    When Je clique sur Register 
    Then je suis rederiger vers la page de creation de compte 
    And Je remplis le formulaire dinscription
    Then le message Welcome est afficher
    And je clique sur logout 
    Then je suis rederiger vers la page dacceuil
    And je remplis les identifiants valide username "user" password "pass"
    Then je suis rederiger vers mon compte

     
    
