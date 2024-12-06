library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity dffv2 is
    Port (
        D : in STD_LOGIC;
        clr : in STD_LOGIC;
        set : in STD_LOGIC;
        clk : in STD_LOGIC;
        q : out STD_LOGIC;
        notq : out STD_LOGIC
    );
end dffv2;

architecture Behavioral of dffv2 is
    signal t : STD_LOGIC;

begin
    t <= '0' when clr = '1' else
         '1' when set = '1' else
         D when rising_edge(clk);
    q <= t;
    notq <= not t;

end Behavioral;