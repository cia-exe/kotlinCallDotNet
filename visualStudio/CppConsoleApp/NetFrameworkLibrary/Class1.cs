using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NetFrameworkLibrary
{
    public class Class1
    {
        public static void go()
        {
            Console.WriteLine("NetFrameworkLibrary.go()!");            
        }
    }

    public class Class2
    {
        public static void go()
        {
            Class1.go();
        }
    }

}

