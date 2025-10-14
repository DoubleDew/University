library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity mux21a is
    Port ( a : in STD_LOGIC;
           b : in STD_LOGIC;
           s : in STD_LOGIC;
           y : out STD_LOGIC
         );
end mux21a;

architecture Behavioral of mux21a is
Begin
    y <= (not s and a) or (s and b);
end Behavioral;