#include "anagram.h"
#include <algorithm>
#include <cstring>

bool anagram::is_anagram(string _test)
{
  transform(_test.begin(), _test.end(), _test.begin(), ::tolower);

  if(word.length() != _test.length())
    return false;

  if(word.compare(_test) == 0)
    return false;

  sort(_test.begin(), _test.end());

  return word_sorted.compare(_test) ? false : true;
}

anagram::anagram(string _word)
{
  word = _word;
  transform(word.begin(), word.end(), word.begin(), ::tolower);
  
  word_sorted = word;
  sort(word_sorted.begin(), word_sorted.end());
}

vector<string> anagram::matches(vector<string> tests)
{
  vector<string> output;
  int size = tests.size();

  for(int i = 0; i < size; i++)
  {
    if(is_anagram(tests[i]))
      output.push_back(tests[i]);
  }

  return output;
}
