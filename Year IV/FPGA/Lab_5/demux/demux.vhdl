entity demux is 
    Port ( a : in STD_LOGIC_VECTOR (0 downto 0);
           s : in STD_LOGIC_VECTOR (1 downto 0);
           z : out STD_LOGIC_VECTOR (3 downto 0)
         );
end demux;

architecture Behavioral of demux is
begin
    z(0) <= (not s(0)) and (not s(1)) and a(0);
    z(1) <= (not s(0)) and s(1) and a(0);
    z(2) <= s(0) and (not s(1)) and a(0);
    z(3) <= s(0) and s(1) and a(0);

end Behavioral;