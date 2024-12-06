library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity mux41 is
    Port ( c : in STD_LOGIC_VECTOR (3 downto 0);
           s : in STD_LOGIC_VECTOR (1 downto 0);
           z : out STD_LOGIC
         );
end mux41;

architecture Behavioral of mux41 is
component mux21a is
    Port( 
        a : in STD_LOGIC;
        b : in STD_LOGIC;
        s : in STD_LOGIC;
        y : out STD_LOGIC
        );
end component;
signal v, w : STD_LOGIC;
begin
    M1 : mux21a
        port map ( 
            a => c(0),
            b => c(1),
            s => s(0),
            y => v
        );
    M2 : mux21a
        port map ( 
            a => c(2),
            b => c(3),
            s => s(0),
            y => w
        );
    M3 : mux21a
        port map ( 
            a => v,
            b => w,
            s => s(1),
            y => z
        );
        
end Behavioral;