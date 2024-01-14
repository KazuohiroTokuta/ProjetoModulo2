using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using EaglesAirlines.Context;
using EaglesAirlines.Models;

namespace EaglesAirlines.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PassageirosController : ControllerBase
    {
        private readonly DataContext _context;

        public PassageirosController(DataContext context)
        {
            _context = context;
        }

        // GET: api/Passageiros
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Passageiros>>> GetPassageiros()
        {
            return await _context.Passageiros.ToListAsync();
        }

        // GET: api/Passageiros/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Passageiros>> GetPassageiros(string id)
        {
            var passageiros = await _context.Passageiros.FindAsync(id);

            if (passageiros == null)
            {
                return NotFound();
            }

            return passageiros;
        }

        // PUT: api/Passageiros/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutPassageiros(string id, Passageiros passageiros)
        {
            if (id != passageiros.CPF)
            {
                return BadRequest();
            }

            _context.Entry(passageiros).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PassageirosExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Passageiros
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Passageiros>> PostPassageiros(Passageiros passageiros)
        {
            _context.Passageiros.Add(passageiros);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (PassageirosExists(passageiros.CPF))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetPassageiros", new { id = passageiros.CPF }, passageiros);
        }

        // DELETE: api/Passageiros/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeletePassageiros(string id)
        {
            var passageiros = await _context.Passageiros.FindAsync(id);
            if (passageiros == null)
            {
                return NotFound();
            }

            _context.Passageiros.Remove(passageiros);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool PassageirosExists(string id)
        {
            return _context.Passageiros.Any(e => e.CPF == id);
        }
    }
}
