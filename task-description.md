# Task Description
 
## 1. WebDriver + Java + TestNG
 
- Select a system under test (preferable: web application being tested during your project activities);
- Agree with your mentor and document 3 scenarios to automate. The scenarios should be linear (no need to implement complex logic for now) and contain 8-10 simple steps;
- Use WebDriver API as much as possible (browser navigation, clicks, switchTo and etc.);
- Use several locator strategies i.e. different types of locators (and select the most suitable in your case);
- Experiment with waits (implicit and explicit);
- Extend your scenario with usage of Page Object / Page Factory patterns.
## 2. Alternative option
 
If option #1 can't be implemented by you due to any technical/project security reasons (project NDA) – use tasks from the eLearning module assigned to the learning path.
 
## 3. Alternative option
 
If option #1 and option #2 can't be implemented by you due to any technical/project security reasons (project NDA) – use a public mail service (for example, Gmail.com and etc.) according the test flow below:
 
**Precondition:** create an account for any mail services mentioned above.
 
**Test scenario/flow:**
 
- Login to the mail box.
- Assert, that the login is successful.
- Create a new mail (fill addressee, subject and body fields).
- Save the mail as a draft.
- Verify, that the mail presents in 'Drafts' folder.
- Verify the draft content (addressee, subject and body – should be the same as in 3).
- Send the mail.
- Verify, that the mail disappeared from 'Drafts' folder.
- Verify, that the mail is in 'Sent' folder.
- Log off.
**Another option** – to use any EPAM service (Heroes, Grow, Time, etc.). In this case make agreement about the scenario with your mentor.
 
## Acceptance criteria
 
1. The scenarios are linear (no need to implement complex logic for now). 3 scenarios in total.
2. Different locator strategies are used for a task.
3. Usage of auto-generated locators is avoided.
4. WebDriver API is widely used.
5. Different methods of waits are used.
6. Test scenarios are clear, stable and good structured.
7. Each method in test scenario has assertions.
8. Page Objects have consistent structure (decomposition of PO is right).
9. Test scenarios are clear, stable and good structured.
10. There is at least one level of inheritance between pages (Abstract Page exists).
11. There is no code duplication at all.
12. Inner implementation of PO is hidden from tests.
13. Naming and Code Conventions should be followed.
 
