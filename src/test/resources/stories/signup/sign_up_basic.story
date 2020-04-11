Narrative:
This story covers vasic tests of signup

Scenario: Type invalid year
Given I open signup page
When I type day "1"
And I set month "April"
And I type year "66"
And I check share
Then I see error "Please enter a valid year."
And I don`t see error "When were you born?"

Scenario: Type invalid email
Given I open signup page
When I type email "test112324@test.com"
And I type confirmation email "wrong@test.com"
And I type name "yuriy"
And I click signup button
Then I see error "Email address doesn't match."

Scenario: Signup with empty password
Given I open signup page
When I type email "test112324@test.com"
And I type confirmation email "wrong@test.com"
And I type name "yuriy"
And I click signup button
Then I see error "Enter a password to continue."

Scenario: Type invalid values
Given I open signup page
When I type email "test112324@test.com"
And I type confirmation email "wrong@test.com"
And I type name "yuriy"
And I set sex "Male"
And I uncheck share
And I click signup button
Then I see "6" errors