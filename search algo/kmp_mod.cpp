#include<bits/stdc++.h>
#include<map>
#include<vector>
using namespace std;
void
Search (char *pat, char *txt)
{
  int fl =0;
  int m = strlen (pat);
  int n = strlen (txt);

  map < char, vector < int >>mp;
  map < char, int >fr;
  for (int i = m - 1; i >= 0; i--)
    {  
      mp[pat[i]].push_back (i);
    }
  vector<int>l_ind(m,0);
  
  
  for (int i = 0; i < m; i++)
    {
      char tp = pat[i];
      if (fr.find (tp) == fr.end ())
	{
	  l_ind[i] = -1;
	  fr[tp] = i;
	}
      else
	{
	  l_ind[i] = fr[tp];
	  fr[tp] = i;
	}
    }

  int j = 0;
  for (int i = 0; i < n;)
    {
      int id = i;
      while (j < m && pat[j] == txt[id])
	{
	  j++;
	  id++;
	}
      if (j == m)
	{
	  cout << "pattern found at " << id - m << endl;
	  i ++;
	  j = 0;
	  fl=1;
	  continue;
	}
     if (i + m < n && fr.find (txt[i + m]) == fr.end ())
	{
	  i = i + m + 1;
	  j = 0;
	  continue;
	}
     if(  i+m >= n) break;
      if (i + m < n && fr.find (txt[i + m]) != fr.end ())
	{
	  char mtch = txt[i + m];
	  int shift = mp[mtch].size ();
	  int alg = 0;
	  while (alg < shift)
	    {
	      int skip = m - mp[mtch][alg];
	      j = 0;
	      id = i + skip;
	      for (j = 0; j < m && id < n; j++, id++)
		{
		  if (pat[j] != txt[id])
		    break;
		}
	      if (j == m){
		cout << "pattern found at index " << id - m << endl;
		fl =1;}
	      alg++;
	      if (id >= m)
		break;
	    }

	}
      i = id;
    }

if( fl == 0) cout<<"pattern found nowhere"<<endl;


}


int main ()
{
  char txt[] = "aaaaabaaag";
  char pat[] = "aaaa";
 Search (pat, txt);
  return 0;
}

/* for( int i =0 ;i<m; i++){
    cout<<l_ind[i]<<' ';
} */

 /* for( auto x: mp){
    std::cout << x.first <<'-';
    for( int i =0 ;i< x.second.size();i++){
    std::cout << x.second[i]<<' ';
    }
    std::cout <<  std::endl;
    } */
