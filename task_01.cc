#include "task_01.h"

#include <string>
#include <vector>
#include <algorithm>

namespace rebtel_task_01
{

bool isValidInput(const char c)
{
    static const std::string validInput = "+- ()";
    if((std::find(validInput.begin(),validInput.end(),c) == validInput.end()) &&
            !isdigit(c))
    {
        return false;
    }
    else
    {
        return true;
    }
}

bool isValidOutput(const char c)
{
    if(c == '+' || isdigit(c))
    {
        return true;
    }
    else
    {
        return false;
    }
}

std::string StripStringAsPhoneNumber(const std::string& input)
{
    std::string ret;
    std::string emptyString;
    unsigned int plusCounter = 0;
    typedef std::string::const_iterator const_iter;

    for(const_iter i = input.begin(); i != input.end(); ++i)
    {
        //first, check if there is any invalid input character
        if(isValidInput(*i))
        {   //the char is valid input, check if it is valid output
            if(isValidOutput(*i))
            {   //the char is valid output, take it in
                ret += *i;
                //check if *i is '+', maintain the counter
                if(*i == '+')
                {
                    ++plusCounter;
                }
            }
        }
        else
        {
            //the char is invalid input, return empty string directly
            return emptyString;
        }
    }
    /*
        a compelete output has been generated,
        check if there is more than one '+' in the number,
        and when there is one '+', if it is at the front
    */

    if((plusCounter == 1 && ret.at(0) == '+') || plusCounter ==0)
    {
        return ret;
    }
    else
    {
        return emptyString;
    }
}

}
