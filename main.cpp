#include "task_01.h"

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

void testTask01()
{
    std::vector<std::string> inputStringVector, outputStringVector;

    inputStringVector.push_back("+46(0)707770001");
    inputStringVector.push_back(" 070-77 70 001");
    inputStringVector.push_back("+46 (0)70 77 70 001");
    inputStringVector.push_back("ABC +46(0)707701");
    inputStringVector.push_back("+46+(0)707770001");
    inputStringVector.push_back("070+77 70 001");
    inputStringVector.push_back("+46070雷77 右使");
    inputStringVector.push_back("+46070 77 noise");

    std::transform(inputStringVector.begin(),
                   inputStringVector.end(),
                   std::back_inserter(outputStringVector),
                   rebtel_task_01::StripStringAsPhoneNumber);

    typedef std::vector<std::string>::const_iterator const_iter;
    const_iter inputIter = inputStringVector.begin();
    const_iter outputIter = outputStringVector.begin();

    while (inputIter != inputStringVector.end())
    {
        std::cout << *inputIter << " ===>" << std::endl
                  << (*outputIter == "" ? "Empty String" : *outputIter)
                  << std::endl
                  << std::endl
                  << std::endl;
        ++inputIter;
        ++outputIter;
    }
}
void testTask02()
{

}

int main()
{
    std::cout << "Input the number to run:" << std::endl
         << "1. Test 1" << std::endl
         << "2. Test 2" << std::endl;

    unsigned int choice = 0;
    std::cin >> choice ;

    switch(choice)
    {
    case 1:
        testTask01();
        break;
    case 2:
        testTask02();
        break;
    default:
        break;
    }
    return 0;
}
