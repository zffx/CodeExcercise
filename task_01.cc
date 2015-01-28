#include "task_01.h"

#include <string>
#include <vector>
#include <algorithm>

namespace rebtel_task_01
{

std::string StripStringAsPhoneNumber(const std::string& input)
{
    static const std::string validInput = "+- ()0123456789";
    static const std::string validOutput = "+0123456789";
    std::string ret;
    std::string emptyString;
    unsigned int plusCounter = 0;
    typedef std::string::const_iterator iter;

    for(iter i = input.begin(); i != input.end(); ++i)
    {
        //first, check if there is any invalid input character
        if(std::find(validInput.begin(),validInput.end(),*i) !=
            validInput.end())
        {   //the char is valid input, check if it is valid output
            if(std::find(validOutput.begin(),validOutput.end(),*i) !=
                validOutput.end())
            {   //the char is valid output, take it in
                ret += *i;
                //check if *i is '+', maintain the counter
                if(*i == '+')
                    ++plusCounter;
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
        return ret;
    else
        return emptyString;
}

}
