using EaglesAirlines.Models;
using Microsoft.EntityFrameworkCore;

namespace EaglesAirlines.Context
{
    public class DataContext : DbContext
    {

        public DataContext(DbContextOptions<DataContext> options) : base(options) { }

        public DbSet<Passageiros> Passageiros { get; set; }
    }
}
