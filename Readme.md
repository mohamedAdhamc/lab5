Written solutions:  
1-  The method f2 in class A is marked as final, which means it cannot be overridden by its subclasses. However, class B attempts to override this method, which will cause a compilation error.

    Class D extends C, but C does not have an implementation for the abstract method f3. This means that class D must provide an implementation for f3, or it too should be marked as abstract.

    Class E extends D, but D is already marked as abstract. This means that class E must provide an implementation for the abstract method f3, or it too should be marked as abstract.
