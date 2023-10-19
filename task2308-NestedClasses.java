package com.codegym.task.task23.task2308;

/* 
Refactoring, nested classes
Refactor the Solution class: put all the constants in the nested public Constants class.
Prevent the Constants class from being inherited.


Requirements:
1. In the Solution class, a Constants class containing string constants must be created.
2. The Constants class must be public.
3. The Constants class must be declared with a modifier that prevents class inheritance.
4. The Constants class should have a SERVER_IS_CURRENTLY_NOT_ACCESSIBLE constant equal to "The server is currently not accessible.".
5. The Constants class should have a USER_IS_NOT_AUTHORIZED constant equal to "The user is not authorized.".
6. The Constants class should have a USER_IS_BANNED constant equal to "The user is banned.".
7. There should be an ACCESS_IS_DENIED constant equal to "Access is denied.".

*/

public class Solution {

    public static final class Constants{
        public static final String SERVER_IS_CURRENTLY_NOT_ACCESSIBLE = "The server is currently not accessible.";
        public static final String USER_IS_NOT_AUTHORIZED = "The user is not authorized.";
        public static final String USER_IS_BANNED = "The user is banned.";
        public static final String ACCESS_IS_DENIED = "Access is denied.";
    }
    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super("The server is currently not accessible.");
        }

        public ServerNotAccessibleException(Throwable cause) {
            super("The server is currently not accessible.", cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super("The user is not authorized.");
        }

        public UnauthorizedUserException(Throwable cause) {
            super("The user is not authorized.", cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super("The user is banned.");
        }

        public BannedUserException(Throwable cause) {
            super("The user is banned.", cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super("Access is denied.");
        }

        public RestrictionException(Throwable cause) {
            super("Access is denied.", cause);
        }
    }

    public static void main(String[] args) {

    }
}
