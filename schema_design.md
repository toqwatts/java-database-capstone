# Schema Design

**MySQL**

Admin
|Key     |value |
|--------|------|
|id      |int   |
|username|string|
|password|char  |

Doctor
|key      |value  |
|---------|-------|
|id       |int    |
|name     |string |
|password |string |
|specialty|string |
|email    |string |
|phone    |string |
|available|List   |

Patient
|key      |value  |
|---------|-------|
|id       |int    |
|name     |string |
|passowrd |string |
|email    |string |
|primary  |string |


Appointment
|key|value|
|----|----|
|id     |int   |
|doctor |string|
|patient|string|
|date   |date|
|time   |time|

**MongoDB**

Prescriptions
|key|value|
|---|-----|
|id|int|
|patientname|string|
|appointmentid|int|
|prescription|string|
|doctornotes|string|
