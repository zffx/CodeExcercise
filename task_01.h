// task_01.h

// The task is to implement a string utility method that strips an input string
// of any characters that are considered "valid for stripping" for the purpose
// of that the output should represent a phone number on a normalized form.

// Example: if input is " +46 (0)70 77 70 001", output should be "+460707770001"


// The following requirements are to be satisfied:

// If the input contains any characters that makes the whole phone number
// invalid regardless of any other stripping, the method should return empty
// string ("").

// Should only return output that is not an empty string ("") in the case that
// once stripping have been applied, the candidate output string can be 
// considered a valid phone number. A valid output string should match the
// following regular expression:
// ^\+?[0-9]+$

// If the input (interpreted as UTF-8 encoded) contains multi-byte codepoints,
// the input should be treated as invalid and the return value should be an
// empty string ("").

// Characters valid for stripping are:
// space ' '
// dash '-'
// parenthesis, '(' or ')'


// Examples:

// input:  "+46(0)707770001"
// output: "+460707770001"

// input:  " 070-77 70 001"
// output: "0707770001"

// input:  " +46 (0)70 77 70 001"
// output: "+460707770001"

// input:  "ABC +46(0)707770001"
// output: ""


// *** Assumptions and additional information ***

// Input should be interpreted as UTF-8 encoded.
// UTF-8 encoding has the property that single-byte codepoints are used only for
// the ASCII values 0 through 127, and in that range the codepoint values have
// the same value as the corresponding character as in ASCII encoding.


// *** Implementation restrictions ***

// Code should comply to the C++98 standard.
// No third-party libraries are allowed.
// Use of the C++ Standard Library is allowed.

#pragma once

#include <string>

namespace rebtel_task_01 {

  std::string StripStringAsPhoneNumber(const std::string& input);

}

