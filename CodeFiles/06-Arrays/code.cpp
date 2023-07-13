#include <iostream>
#include <string>
#include <bits/stdc++.h>
#include <map>
#include <vector>
#include <fstream>
#include <cstdlib>

int processArray(std::vector<int> &array)
{
  int smallcent = INT_MAX;

  for (int i = 0; i < array.size(); i++)
  {
    if (array[i] >= 100 && array[i] < smallcent) 
    {
      smallcent = array[i];
    }
  }

  return smallcent;
}

int main(void) {
  std::vector<int> array;
  int val;
  while (std::cin >> val) {
    if (val < 0) break;
    array.push_back(val);
  }
  std::cout << processArray(array) << std::endl;
  return 0;
}