library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity mux21c is
    Port ( a : in STD_LOGIC;
           b : in STD_LOGIC;
           s : in STD_LOGIC;
           y : out STD_LOGIC
         );
end mux21c;

architecture Behavioral of mux21c is

begin
    y <= a when s = '0' else b;

end Behavioral;